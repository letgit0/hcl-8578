package org.abes.hrmsdatabase.controller;
import org.abes.hrmsdatabase.model.Attendance;
import org.abes.hrmsdatabase.service.AttendanceService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.time.LocalDate;
import java.util.List;
import java.util.Map;
@RestController
@RequestMapping("/api/attendance")
@CrossOrigin(origins = {"http://localhost:5173", "http://127.0.0.1:5173"})
public class AttendanceController {
  private final AttendanceService attendanceService;
  public AttendanceController(AttendanceService attendanceService){this.attendanceService=attendanceService;}
  @GetMapping public List<Attendance> getAll(){return attendanceService.getAll();}
  @PostMapping public ResponseEntity<?> mark(@RequestBody MarkAttendanceRequest request){
    if(request.employeeId()==null || request.employeeId()<=0) return ResponseEntity.badRequest().body(Map.of("message","Valid employee ID is required"));
    try { return ResponseEntity.ok(attendanceService.markAttendance(request.employeeId(), request.date(), request.comment())); }
    catch(IllegalArgumentException ex){return ResponseEntity.badRequest().body(Map.of("message",ex.getMessage()));}
  }
  public record MarkAttendanceRequest(Long employeeId, LocalDate date, String comment){}
}
