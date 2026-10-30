package org.abes.hrmsdatabase.model;
import jakarta.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
@Entity
@Table(name="attendance")
public class Attendance {
  @Id @GeneratedValue(strategy=GenerationType.IDENTITY) @Column(name="attendance_id") private Long attendanceId;
  @ManyToOne(fetch=FetchType.EAGER, optional=false) @JoinColumn(name="emp_id", nullable=false) private Employee employee;
  @Column(name="attendance_date", nullable=false) private LocalDate attendancedate;
  private LocalDateTime inTime;
  private LocalDateTime outTime;
  private String comment;
  public Attendance(){}
  public Long getAttendanceId(){return attendanceId;} public void setAttendanceId(Long attendanceId){this.attendanceId=attendanceId;}
  public Employee getEmployee(){return employee;} public void setEmployee(Employee employee){this.employee=employee;}
  public LocalDate getAttendancedate(){return attendancedate;} public void setAttendancedate(LocalDate attendancedate){this.attendancedate=attendancedate;}
  public LocalDateTime getInTime(){return inTime;} public void setInTime(LocalDateTime inTime){this.inTime=inTime;}
  public LocalDateTime getOutTime(){return outTime;} public void setOutTime(LocalDateTime outTime){this.outTime=outTime;}
  public String getComment(){return comment;} public void setComment(String comment){this.comment=comment;}
}
