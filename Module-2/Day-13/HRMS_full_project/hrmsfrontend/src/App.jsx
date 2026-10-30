import { useCallback, useEffect, useState } from 'react';
import { Users, UserPlus, ShieldCheck, CalendarCheck, RefreshCw, Trash2, Search, CheckCircle2, AlertCircle, LayoutDashboard, LogOut, LockKeyhole } from 'lucide-react';
const API = 'http://localhost:8080/api';
async function request(path, options = {}) {
  const response = await fetch(`${API}${path}`, { headers: { 'Content-Type': 'application/json', ...(options.headers || {}) }, ...options });
  const contentType = response.headers.get('content-type') || '';
  const data = contentType.includes('application/json') ? await response.json() : await response.text();
  if (!response.ok) throw new Error(data?.message || data || `Request failed (${response.status})`);
  return data;
}
function Notice({ notice }) { if (!notice) return null; return <div className={`notice ${notice.type}`} role="status">{notice.type === 'success' ? <CheckCircle2 size={18}/> : <AlertCircle size={18}/>}<span>{notice.text}</span></div>; }
export default function App() {
  const [tab, setTab] = useState('overview');
  const [auth, setAuth] = useState(null);
  const [loginForm, setLoginForm] = useState({ email: 'admin@abes.ac.in', password: '' });
  const [loginError, setLoginError] = useState('');
  const [loginBusy, setLoginBusy] = useState(false);
  const [employees, setEmployees] = useState([]);
  const [attendance, setAttendance] = useState([]);
  const [loading, setLoading] = useState(false);
  const [notice, setNotice] = useState(null);
  const [search, setSearch] = useState('');
  const [employeeForm, setEmployeeForm] = useState({ emp_id: '', emp_name: '', email: '', designation: '', stack: '' });
  const [verifyForm, setVerifyForm] = useState({ id: '', email: '' });
  const [verified, setVerified] = useState(null);
  const [attendanceForm, setAttendanceForm] = useState({ employeeId: '', date: new Date().toLocaleDateString('en-CA'), comment: 'Present' });
  const loadData = useCallback(async () => {
    setLoading(true);
    try {
      const [employeeData, attendanceData] = await Promise.all([request('/employees'), request('/attendance')]);
      setEmployees(employeeData); setAttendance(attendanceData);
    } catch (error) { setNotice({ type: 'error', text: `${error.message}. Check that Spring Boot and MySQL are running.` }); }
    finally { setLoading(false); }
  }, []);
  useEffect(() => { if (auth) loadData(); }, [loadData, auth]);
  async function login(e) {
    e.preventDefault(); setLoginError(''); setLoginBusy(true);
    try { const result = await request('/auth/login', { method: 'POST', body: JSON.stringify(loginForm) }); setAuth({ name: result.name, email: result.email }); }
    catch (error) { setLoginError(error.message || 'Login failed. Check the backend.'); }
    finally { setLoginBusy(false); }
  }
  function logout() { setAuth(null); setEmployees([]); setAttendance([]); setTab('overview'); setNotice(null); setLoginForm({ email: 'admin@abes.ac.in', password: '' }); }
  const updateEmployee = (e) => setEmployeeForm({ ...employeeForm, [e.target.name]: e.target.value });
  async function createEmployee(e) {
    e.preventDefault(); setNotice(null);
    try {
      const saved = await request('/employees', { method: 'POST', body: JSON.stringify({ ...employeeForm, emp_id: Number(employeeForm.emp_id) }) });
      setNotice({ type: 'success', text: `Employee ${saved.emp_name} registered successfully.` });
      setEmployeeForm({ emp_id: '', emp_name: '', email: '', designation: '', stack: '' }); await loadData(); setTab('employees');
    } catch (error) { setNotice({ type: 'error', text: error.message }); }
  }
  async function verifyEmployee(e) {
    e.preventDefault(); setNotice(null); setVerified(null);
    try {
      const result = await request(`/employees/verify?id=${encodeURIComponent(verifyForm.id)}&email=${encodeURIComponent(verifyForm.email)}`);
      setVerified(result.employee); setNotice({ type: 'success', text: result.message });
    } catch (error) { setNotice({ type: 'error', text: error.message }); }
  }
  async function deleteEmployee(id) {
    if (!window.confirm(`Delete employee ID ${id}? This cannot be undone.`)) return;
    try { const result = await request(`/employees/${id}`, { method: 'DELETE' }); setNotice({ type: 'success', text: result.message }); await loadData(); }
    catch (error) { setNotice({ type: 'error', text: error.message }); }
  }
  async function markAttendance(e) {
    e.preventDefault(); setNotice(null);
    try {
      await request('/attendance', { method: 'POST', body: JSON.stringify({ employeeId: Number(attendanceForm.employeeId), date: attendanceForm.date || null, comment: attendanceForm.comment }) });
      setNotice({ type: 'success', text: 'Attendance marked successfully.' }); await loadData(); setTab('attendance');
    } catch (error) { setNotice({ type: 'error', text: error.message }); }
  }
  const filtered = employees.filter(emp => [emp.emp_name, emp.email, emp.designation, String(emp.emp_id)].some(v => (v || '').toLowerCase().includes(search.toLowerCase())));
  if (!auth) return <div className="login-page"><div className="login-card"><div className="login-brand"><div className="brand-icon">A</div><div><strong>ABES HRMS</strong><small>Human Resource Management</small></div></div><div className="login-icon"><LockKeyhole size={25}/></div><p className="login-eyebrow">WELCOME BACK</p><h1>Sign in to your workspace</h1><p className="login-subtitle">Use your HR administrator account to manage employee records and attendance.</p><form onSubmit={login} className="login-form"><label className="field"><span>Email address</span><input type="email" value={loginForm.email} onChange={e=>setLoginForm({...loginForm,email:e.target.value})} autoComplete="username" placeholder="admin@abes.ac.in" required/></label><label className="field"><span>Password</span><input type="password" value={loginForm.password} onChange={e=>setLoginForm({...loginForm,password:e.target.value})} autoComplete="current-password" placeholder="Enter your password" required/></label>{loginError && <div className="login-error"><AlertCircle size={17}/>{loginError}</div>}<button className="primary-btn full login-submit" type="submit" disabled={loginBusy}>{loginBusy?'Signing in…':'Sign in'}</button></form><div className="login-hint"><strong>First-time demo login</strong><span>Email: admin@abes.ac.in</span><span>Password: Admin@123</span><small>Change the demo password before using this with real data.</small></div></div><p className="login-footer">ABES HRMS · Local development demo</p></div>;
  return <div className="app-shell">
    <aside className="sidebar"><div className="brand"><div className="brand-icon">A</div><div><strong>ABES HRMS</strong><small>Employee management</small></div></div>
      <div className="nav-label">WORKSPACE</div>
      {[['overview','Overview',LayoutDashboard],['employees','Employees',Users],['register','Register employee',UserPlus],['verify','Verify employee',ShieldCheck],['attendance','Attendance',CalendarCheck]].map(([key,label,Icon]) => <button key={key} className={`nav-item ${tab===key?'active':''}`} onClick={()=>{setTab(key);setNotice(null);}}><Icon size={18}/><span>{label}</span></button>)}
      <div className="sidebar-bottom"><span className="status-dot"/> API connection uses localhost:8080 <button className="refresh-link" onClick={loadData}><RefreshCw size={14}/> Refresh data</button></div>
    </aside>
    <main className="main-content"><header className="topbar"><div><p className="eyebrow">HUMAN RESOURCE MANAGEMENT</p><h1>{({overview:'Overview',employees:'Employees',register:'Register employee',verify:'Employee verification',attendance:'Attendance'})[tab]}</h1></div><div className="top-actions"><span className="api-pill"><span className="status-dot"/> Spring Boot API</span><div className="avatar" title={auth.email}>{(auth.name || 'HR').split(' ').map(part=>part[0]).join('').slice(0,2).toUpperCase()}</div><button className="logout-btn" onClick={logout}><LogOut size={15}/> Logout</button></div></header>
      <Notice notice={notice}/>
      {tab==='overview' && <>
        <section className="welcome"><div><span className="welcome-tag">HRMS DASHBOARD</span><h2>People first. Work made simpler.</h2><p>Manage employee records, verify employee details, and mark daily attendance in one place.</p><button className="primary-btn" onClick={()=>setTab('register')}><UserPlus size={17}/> Add an employee</button></div><div className="welcome-art"><div className="art-circle"><Users size={58}/></div><div className="art-chip chip-one">Employee records</div><div className="art-chip chip-two">Connected to MySQL</div></div></section>
        <section className="stats-grid"><Stat icon={Users} label="Total employees" value={employees.length} hint="Records in database"/><Stat icon={CalendarCheck} label="Attendance entries" value={attendance.length} hint="Saved attendance records"/><Stat icon={ShieldCheck} label="Verification" value="Ready" hint="ID + email match"/></section>
        <section className="panel"><div className="panel-heading"><div><h3>Recently registered employees</h3><p>Latest records available from your backend</p></div><button className="text-btn" onClick={()=>setTab('employees')}>View all <span>→</span></button></div><EmployeeTable employees={employees.slice(-5).reverse()} onDelete={deleteEmployee} compact/></section>
      </>}
      {tab==='employees' && <section className="panel"><div className="panel-heading"><div><h3>Employee directory</h3><p>Employee data loaded from the Spring Boot API</p></div><button className="primary-btn small" onClick={()=>setTab('register')}><UserPlus size={16}/> Register employee</button></div><div className="search-box"><Search size={17}/><input value={search} onChange={e=>setSearch(e.target.value)} placeholder="Search by name, ID, email or designation"/></div><EmployeeTable employees={filtered} onDelete={deleteEmployee}/></section>}
      {tab==='register' && <section className="form-layout"><div className="panel form-panel"><div className="panel-heading"><div><h3>Employee details</h3><p>Complete the fields below to save a record in MySQL.</p></div><div className="soft-icon"><UserPlus size={21}/></div></div><form onSubmit={createEmployee} className="form-grid"><Field label="Employee ID" hint="Must be unique"><input name="emp_id" type="number" min="1" value={employeeForm.emp_id} onChange={updateEmployee} placeholder="e.g. 101" required/></Field><Field label="Full name"><input name="emp_name" value={employeeForm.emp_name} onChange={updateEmployee} placeholder="Enter employee name" required/></Field><Field label="Email address"><input name="email" type="email" value={employeeForm.email} onChange={updateEmployee} placeholder="name@example.com" required/></Field><Field label="Designation"><input name="designation" value={employeeForm.designation} onChange={updateEmployee} placeholder="e.g. Software Engineer"/></Field><Field label="Tech stack" wide><input name="stack" value={employeeForm.stack} onChange={updateEmployee} placeholder="e.g. Java, Spring Boot, React"/></Field><div className="form-footer"><span>Fields marked * are required.</span><button className="primary-btn" type="submit"><UserPlus size={17}/> Save employee</button></div></form></div><div className="tip-card"><div className="soft-icon"><ShieldCheck size={22}/></div><h3>Before you save</h3><ul><li>Employee ID must be unique.</li><li>Email must be valid and unique.</li><li>After saving, the record is sent to your backend API.</li></ul><div className="flow-note"><span>React UI</span><b>→</b><span>Spring Boot</span><b>→</b><span>MySQL</span></div></div></section>}
      {tab==='verify' && <section className="verify-layout"><div className="panel verify-panel"><div className="verify-icon"><ShieldCheck size={28}/></div><h3>Verify employee details</h3><p>Enter the employee ID and the email registered for that employee. The backend checks whether both values match.</p><form onSubmit={verifyEmployee} className="verify-form"><Field label="Employee ID"><input type="number" min="1" value={verifyForm.id} onChange={e=>setVerifyForm({...verifyForm,id:e.target.value})} placeholder="Enter employee ID" required/></Field><Field label="Registered email"><input type="email" value={verifyForm.email} onChange={e=>setVerifyForm({...verifyForm,email:e.target.value})} placeholder="Enter registered email" required/></Field><button className="primary-btn full" type="submit"><ShieldCheck size={17}/> Verify employee</button></form>{verified && <div className="verified-card"><CheckCircle2 size={21}/><div><strong>{verified.emp_name}</strong><p>ID {verified.emp_id} · {verified.designation || 'No designation added'}</p><small>{verified.email}</small></div></div>}</div><div className="tip-card"><h3>How verification works</h3><ol><li>Frontend sends ID and email as request parameters.</li><li>Controller reads them using <code>@RequestParam</code>.</li><li>Service compares them with the employee record.</li></ol><code className="endpoint">GET /api/employees/verify?id=101&amp;email=...</code><p className="muted">This confirms an existing record; it does not send an email OTP.</p></div></section>}
      {tab==='attendance' && <section className="attendance-layout"><div className="panel"><div className="panel-heading"><div><h3>Mark attendance</h3><p>Select an existing employee and record attendance.</p></div><div className="soft-icon"><CalendarCheck size={21}/></div></div><form onSubmit={markAttendance} className="stack-form"><Field label="Employee"><select value={attendanceForm.employeeId} onChange={e=>setAttendanceForm({...attendanceForm,employeeId:e.target.value})} required><option value="">Select employee</option>{employees.map(emp=><option key={emp.emp_id} value={emp.emp_id}>{emp.emp_name} (ID: {emp.emp_id})</option>)}</select></Field><Field label="Attendance date"><input type="date" value={attendanceForm.date} onChange={e=>setAttendanceForm({...attendanceForm,date:e.target.value})} required/></Field><Field label="Note"><input value={attendanceForm.comment} onChange={e=>setAttendanceForm({...attendanceForm,comment:e.target.value})} placeholder="e.g. Present"/></Field><button className="primary-btn" type="submit"><CalendarCheck size={17}/> Mark attendance</button></form></div><div className="panel"><div className="panel-heading"><div><h3>Attendance records</h3><p>{attendance.length} saved entries</p></div></div>{attendance.length===0?<Empty message="No attendance entries yet."/>:<div className="attendance-list">{[...attendance].reverse().slice(0,8).map((a,i)=><div className="attendance-row" key={a.attendanceId ?? i}><div className="attendance-date">{a.attendancedate || '—'}</div><div className="attendance-person"><strong>{a.employee?.emp_name || `Employee ${a.employee?.emp_id || ''}`}</strong><small>{a.comment || 'Attendance marked'}</small></div><span className="present-badge">Saved</span></div>)}</div>}</div></section>}
      <footer className="footer"><span>ABES HRMS · Learning project</span><span>{loading?'Syncing with backend…':'Data syncs with your local Spring Boot API'}</span></footer>
    </main>
  </div>;
}
function Stat({icon:Icon,label,value,hint}){return <div className="stat-card"><div className="stat-top"><span>{label}</span><div className="stat-icon"><Icon size={19}/></div></div><strong>{value}</strong><small>{hint}</small></div>}
function Field({label,hint,wide,children}){return <label className={`field ${wide?'wide':''}`}><span>{label}<b> *</b></span>{children}{hint&&<small>{hint}</small>}</label>}
function Empty({message}){return <div className="empty-state"><Users size={25}/><span>{message}</span></div>}
function EmployeeTable({employees,onDelete,compact=false}){if(!employees.length)return <Empty message="No employees found. Register an employee to get started."/>;return <div className="table-wrap"><table><thead><tr><th>Employee</th><th>Employee ID</th><th>Designation</th><th>Tech stack</th>{!compact&&<th>Action</th>}</tr></thead><tbody>{employees.map(emp=><tr key={emp.emp_id}><td><div className="person-cell"><div className="person-avatar">{(emp.emp_name||'?').slice(0,1).toUpperCase()}</div><div><strong>{emp.emp_name}</strong><small>{emp.email}</small></div></div></td><td><span className="id-tag">#{emp.emp_id}</span></td><td>{emp.designation||'—'}</td><td>{emp.stack||'—'}</td>{!compact&&<td><button className="delete-btn" title="Delete employee" onClick={()=>onDelete(emp.emp_id)}><Trash2 size={16}/></button></td>}</tr>)}</tbody></table></div>}
