
import React, { useState } from 'react';

function Register() {
  const [Empid, setEmpid] = useState('');
  const [EmpName, setEmpName] = useState('');
  const [EmpDesignation, setEmpDesignation] = useState('');
  const [EmpStack, setEmpStack] = useState('');
  const [email, setEmail] = useState('');

  const [message, setMessage] = useState('');
  const [loading, setLoading] = useState(false);

  
async function SendData(e) {
  e.preventDefault();

  const employee = {
    emp_id: Number(Empid),
    emp_name: EmpName,
    stack: EmpStack,
    designation: EmpDesignation,
    email: email
  };

  try {
    const response = await fetch(
      'http://localhost:8080/addemp',
      {
        method: 'POST',
        headers: {
          'Content-Type': 'application/json'
        },
        body: JSON.stringify(employee)
      }
    );

    const result = await response.text();

    if (!response.ok) {
      throw new Error(result || `HTTP ${response.status}`);
    }

    alert(result);

    setEmpid('');
    setEmpName('');
    setEmpStack('');
    setEmpDesignation('');
    setEmail('');

  } catch (error) {
    console.error(error);
    alert(`Registration failed: ${error.message}`);
  }
}


  return (
    <div className="container mt-4">
      <h2 className="mb-4">Employee Registration</h2>

      <form onSubmit={SendData}>
        <div className="mb-3">
          <label className="form-label">Employee ID</label>
          <input
            type="number"
            className="form-control"
            placeholder="Enter employee ID"
            value={Empid}
            onChange={(e) => setEmpid(e.target.value)}
            required
          />
        </div>

        <div className="mb-3">
          <label className="form-label">Name</label>
          <input
            type="text"
            className="form-control"
            placeholder="Enter name"
            value={EmpName}
            onChange={(e) => setEmpName(e.target.value)}
            required
          />
        </div>

        <div className="mb-3">
          <label className="form-label">Email Address</label>
          <input
            type="email"
            className="form-control"
            placeholder="Enter email"
            value={email}
            onChange={(e) => setEmail(e.target.value)}
            required
          />
        </div>

        <div className="mb-3">
          <label className="form-label">Designation</label>
          <input
            type="text"
            className="form-control"
            placeholder="Enter designation"
            value={EmpDesignation}
            onChange={(e) => setEmpDesignation(e.target.value)}
            required
          />
        </div>

        <div className="mb-3">
          <label className="form-label">Tech Stack</label>
          <input
            type="text"
            className="form-control"
            placeholder="e.g. Java, React"
            value={EmpStack}
            onChange={(e) => setEmpStack(e.target.value)}
            required
          />
        </div>

        <button
          type="submit"
          className="btn btn-primary w-100"
          disabled={loading}
        >
          {loading ? 'Registering...' : 'Register'}
        </button>

        {message && (
          <p className="mt-3" role="status">
            {message}
          </p>
        )}
      </form>
    </div>
  );
}

export default Register;
