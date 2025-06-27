package com.noticehub.service.impl;

import com.noticehub.dto.TeacherDto;
import com.noticehub.entity.*;
import com.noticehub.enums.Gender;
import com.noticehub.enums.Status;
import com.noticehub.exception.DuplicateResourceException;
import com.noticehub.exception.ResourceNotFoundException;
import com.noticehub.mapper.TeacherMapper;
import com.noticehub.repository.*;
import com.noticehub.service.TeacherService;
import jakarta.transaction.Transactional;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TeacherImpl implements TeacherService {

    private final TeacherRepository teacherRepository;
    private final UserRepository userRepository;
    private final DepartmentRepository departmentRepository;
    private final DesignationRepository designationRepository;
    private final AuthorityRepository authorityRepository;
    private final JobTypeRepository jobTypeRepository;
    private final RoleRepository roleRepository;
    private final PasswordEncoder passwordEncoder;

    public TeacherImpl(
            TeacherRepository teacherRepository,
            UserRepository userRepository,
            DepartmentRepository departmentRepository,
            DesignationRepository designationRepository,
            AuthorityRepository authorityRepository,
            JobTypeRepository jobTypeRepository, RoleRepository roleRepository, PasswordEncoder passwordEncoder) {
        this.teacherRepository = teacherRepository;
        this.userRepository = userRepository;
        this.departmentRepository = departmentRepository;
        this.designationRepository = designationRepository;
        this.authorityRepository = authorityRepository;
        this.jobTypeRepository = jobTypeRepository;
        this.roleRepository = roleRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    @Transactional
    public TeacherDto createTeacher(TeacherDto teacherDto) {
        // Check for duplicates
        StringBuilder duplicateFields = new StringBuilder();

        if (teacherRepository.existsByEmail(teacherDto.email())) {
            duplicateFields.append("Email, ");
        }

        if (teacherRepository.existsByContact(teacherDto.contact())) {
            duplicateFields.append("Contact, ");
        }

        if (teacherRepository.existsByIdNumber(teacherDto.idNumber())) {
            duplicateFields.append("ID Number, ");
        }

        if (!duplicateFields.isEmpty()) {
            String fields = duplicateFields.substring(0, duplicateFields.length() - 2);
            throw new DuplicateResourceException("Teacher with same" + fields + " already exists.");
        }

        // Role
        Role teacherRole = roleRepository.findByName("TEACHER")
                .orElseThrow(() -> new ResourceNotFoundException("Role 'TEACHER' does not exists!"));

        // Create User
        User user = User.builder()
                .email(teacherDto.email())
                .password(passwordEncoder.encode(teacherDto.password()))
                .role(teacherRole)
                .status(User.Status.ACTIVE)
                .build();
        userRepository.save(user);

        // Other entities
        Department department = departmentRepository.findById(teacherDto.departmentId())
                .orElseThrow(() -> new ResourceNotFoundException("Department does not exists!"));

        Designation designation = designationRepository.findById(teacherDto.designationId())
                .orElseThrow(() -> new ResourceNotFoundException("Designation does not exists!"));

        Authority authority = authorityRepository.findById(teacherDto.authorityId())
                .orElseThrow(() -> new ResourceNotFoundException("Authority does not exists!"));

        JobType jobType = jobTypeRepository.findById(teacherDto.jobTypeId())
                .orElseThrow(() -> new ResourceNotFoundException("Job Type does not exists!"));

        // Save Teacher
        Teacher teacher = TeacherMapper.mapToTeacher(teacherDto, user, department, designation, authority, jobType);
        Teacher saved = teacherRepository.save(teacher);

        return TeacherMapper.mapToTeacherDto(saved);
    }

    @Override
    public TeacherDto updateTeacher(Long id, TeacherDto dto) {

        Teacher teacher = teacherRepository
                .findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Teacher does not exists!"));

        // Keep current linked user
        User user = teacher.getUser();
        if (!user.getEmail().equals(dto.email())) {
            user.setEmail(dto.email());
        }

        if (dto.password() != null && !dto.password().isBlank()) {
            user.setPassword(passwordEncoder.encode(dto.password()));
        }

        userRepository.save(user);

        Department department = departmentRepository
                .findById(dto.departmentId())
                .orElseThrow(() -> new ResourceNotFoundException("Department does not exists!"));

        Designation designation = designationRepository
                .findById(dto.designationId())
                .orElseThrow(() -> new ResourceNotFoundException("Designation does not exists!"));

        Authority authority = authorityRepository
                .findById(dto.authorityId())
                .orElseThrow(() -> new ResourceNotFoundException("Authority does not exists!"));

        JobType jobType = jobTypeRepository
                .findById(dto.jobTypeId())
                .orElseThrow(() -> new ResourceNotFoundException("Job Type does not exists!"));

        teacher.setIdNumber(dto.idNumber());
        teacher.setFirstName(dto.firstName());
        teacher.setLastName(dto.lastName());
        teacher.setEmail(dto.email());
        teacher.setDateOfBirth(dto.dateOfBirth());
        teacher.setGender(dto.gender());
        teacher.setAddress(dto.address());
        teacher.setContact(dto.contact());
        teacher.setProfileImage(dto.profileImage());
        teacher.setStatus(dto.status());
        teacher.setDescription(dto.description());
        teacher.setQualification(dto.qualification());
        teacher.setSpecialization(dto.specialization());

        teacher.setUser(user);
        teacher.setDepartment(department);
        teacher.setDesignation(designation);
        teacher.setAuthority(authority);
        teacher.setJobType(jobType);

        Teacher updated = teacherRepository.save(teacher);
        return TeacherMapper.mapToTeacherDto(updated);
    }

    @Override
    public TeacherDto getTeacherById(Long id) {
        Teacher teacher = teacherRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Teacher does not exists!"));
        return TeacherMapper.mapToTeacherDto(teacher);
    }

    @Override
    @Transactional
    public void deleteTeacher(Long id) {
        Teacher teacher = teacherRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Teacher does not exists!"));

        teacher.setStatus(Status.INACTIVE);
        teacherRepository.save(teacher);

        User user = teacher.getUser();
        user.setStatus(User.Status.INACTIVE);
        userRepository.save(user);

    }

    @Override
    public List<TeacherDto> getAllTeachers() {
        return List.of();
    }
}
