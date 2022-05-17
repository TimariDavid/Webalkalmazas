import React from 'react';
import { Navbar, Nav, NavDropdown, Form, Button, FormControl } from 'react-bootstrap';
import '../../css/bootstrap.min.css';

function MainNavigation() {
  return (
    <div><Navbar bg="dark" variant="dark" expand="lg">
        <Navbar.Brand href="/">Home</Navbar.Brand>
        <Navbar.Toggle aria-controls="basic-navbar-nav" />
        <Navbar.Collapse id="basic-navbar-nav">
            <Nav className="mr-auto">
              <Nav.Link href="/phone">Phone</Nav.Link>
              <Nav.Link href="/tablet">Tablet</Nav.Link>
              <Nav.Link href="/watch">Watch</Nav.Link>
              <Nav.Link href="/tvhome">TV</Nav.Link>
            </Nav>
        </Navbar.Collapse>
    </Navbar>

    </div>
);
}

export default MainNavigation;
