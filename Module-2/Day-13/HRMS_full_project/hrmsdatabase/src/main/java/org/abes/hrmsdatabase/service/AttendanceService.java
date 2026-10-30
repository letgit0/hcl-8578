package org.abes.hrmsdatabase.service;
import org.abes.hrmsdatabase.model.Attendance;
import org.abes.hrmsdatabase.model.Employee;
import org.abes.hrmsdatabase.repository.AttendanceRepository;
import org.abes.hrmsdatabase.repository.EmployeeRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
@Service
public class AttendanceService {
  private final AttendanceRepository attendanceRepository;
  private final EmployeeRepository employeeRepository;
  public AttendanceService(AttendanceRepository attendanceRepository, EmployeeRepository employeeRepository){this.attendanceRepository=attendanceRepository;this.employeeRepository=employeeRepository;}
  @Transactional public Attendance markAttendance(Long employeeId, LocalDate date, String comment){
    Employee employee=employeeRepository.findById(employeeId).orElseThrow(()->new IllegalArgumentException("Employee not found"));
    Attendance attendance=new Attendance(); attendance.setEmployee(employee); attendance.setAttendancedate(date==null?LocalDate.now():date); attendance.setInTime(LocalDateTime.now()); attendance.setComment(comment);
    return attendanceRepository.save(attendance);
  }
  public List<Attendance> getAll(){return attendanceRepository.findAll();}
}
