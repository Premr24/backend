package com.noticehub.service.impl;

import com.noticehub.dto.StudentDto;
import com.noticehub.entity.*;
import com.noticehub.enums.Status;
import com.noticehub.exception.ResourceNotFoundException;
import com.noticehub.mapper.StudentMapper;
import com.noticehub.repository.*;
import com.noticehub.service.StudentService;
import jakarta.transaction.Transactional;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class StudentImpl implements StudentService {
    private final StudentRepository studentRepository;
    private final UserRepository userRepository;
    private final ProgramRepository programRepository;
    private final SemesterRepository semesterRepository;
    private final RoleRepository roleRepository;
    private final PasswordEncoder passwordEncoder;

    public StudentImpl(
            StudentRepository studentRepository,
            UserRepository userRepository,
            ProgramRepository programRepository,
            SemesterRepository semesterRepository,
            RoleRepository roleRepository,
            PasswordEncoder passwordEncoder
    ) {
        this.studentRepository = studentRepository;
        this.userRepository = userRepository;
        this.programRepository = programRepository;
        this.semesterRepository = semesterRepository;
        this.roleRepository = roleRepository;
        this.passwordEncoder = passwordEncoder;
    }


    @Override
    @Transactional
    public StudentDto createStudent(StudentDto studentDto) {
        Role studentRole = roleRepository.findByName("STUDENT")
                .orElseThrow(() -> new ResourceNotFoundException("Role 'STUDENT' not found"));

        User user = User.builder()
                .email(studentDto.email())
                .password(passwordEncoder.encode(studentDto.password()))
                .role(studentRole)
                .status(User.Status.ACTIVE)
                .build();

        userRepository.save(user);

        Program program = programRepository.findById(studentDto.programId())
                .orElseThrow(() -> new ResourceNotFoundException("Program not found"));

        Semester semester = semesterRepository.findById(studentDto.semesterId())
                .orElseThrow(() -> new ResourceNotFoundException("Semester not found"));

        Student student = StudentMapper.mapToStudent(studentDto, user, program, semester);
        Student saved = studentRepository.save(student);

        return StudentMapper.mapToStudentDto(saved);
    }

    @Override
    public StudentDto updateStudent(Long id, StudentDto studentDto) {
        Student student = studentRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Student not found"));

        User user = student.getUser();

        if (!user.getEmail().equals(studentDto.email())) {
            user.setEmail(studentDto.email());
        }

        if (studentDto.password() != null && !studentDto.password().isBlank()) {
            user.setPassword(passwordEncoder.encode(studentDto.password()));
        }

        userRepository.save(user);

        Program program = programRepository.findById(studentDto.programId())
                .orElseThrow(() -> new ResourceNotFoundException("Program not found"));

        Semester semester = semesterRepository.findById(studentDto.semesterId())
                .orElseThrow(() -> new ResourceNotFoundException("Semester not found"));

        student.setIdNumber(studentDto.idNumber());
        student.setFirstName(studentDto.firstName());
        student.setLastName(studentDto.lastName());
        student.setEmail(studentDto.email());
        student.setDateOfBirth(studentDto.dateOfBirth());
        student.setGender(studentDto.gender());
        student.setAddress(studentDto.address());
        student.setContact(studentDto.contact());
        student.setProfileImage(studentDto.profileImage());
        student.setStatus(studentDto.status());
        student.setDescription(studentDto.description());

        student.setUser(user);
        student.setProgram(program);
        student.setSemester(semester);

        Student updated = studentRepository.save(student);

        return StudentMapper.mapToStudentDto(updated);
    }

    @Override
    public StudentDto getStudentById(Long id) {
        Student student = studentRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Student not found"));

        return StudentMapper.mapToStudentDto(student);
    }

    @Override
    @Transactional
    public void deleteStudent(Long id) {

        Student student = studentRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Student not found"));

        student.setStatus(Status.INACTIVE);
        studentRepository.save(student);

        User user = student.getUser();
        user.setStatus(User.Status.INACTIVE);
        userRepository.save(user);
    }

}

