import React, { useState, useEffect } from 'react';
import { FaBars, FaTimes } from 'react-icons/fa';
import { IconContext } from 'react-icons/lib';
import { Button } from '../../globalStyles';
import {
  Nav,
  NavbarContainer,
  NavLogo,
  MobileIcon,
  NavMenu,
  NavItem,
  NavItemBtn,
  NavLinks,
  NavBtnLink
} from './NavbarElements';

function Navbar() {
  const [click, setClick] = useState(false);
  const [button, setButton] = useState(true);

  const handleClick = () => setClick(!click);
  const closeMobileMenu = () => setClick(false);

  const showButton = () => {
    if (window.innerWidth <= 960) {
      setButton(false);
    } else {
      setButton(true);
    }
  };

  useEffect(() => {
    showButton();
  }, []);

  window.addEventListener('resize', showButton);

  return (
    <>
      <IconContext.Provider value={{ color: '#fff' }}>
        <Nav>
          <NavbarContainer>
            <NavLogo to='/' onClick={closeMobileMenu}>
              Cinema_Now
            </NavLogo>
            <MobileIcon onClick={handleClick}>
              {click ? <FaTimes /> : <FaBars />}
            </MobileIcon>
            <NavMenu onClick={handleClick} click={click}>
              <NavItem>
                <NavLinks to='/' onClick={closeMobileMenu}>
                  News
                </NavLinks>
              </NavItem>
              <NavItem>
                <NavLinks to='/schedule' onClick={closeMobileMenu}>
                  Schedule
                </NavLinks>
              </NavItem>
              <NavItem>
                <NavLinks to='/complaints' onClick={closeMobileMenu}>
                  Complaints
                </NavLinks>
              </NavItem>
              <NavItem>
                <NavLinks to='/api_user_test' onClick={closeMobileMenu}>
                  API_Test
                </NavLinks>
              </NavItem>
              &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
              <NavItemBtn>    
                         
                {button ? (
                  <NavBtnLink to='/sign-up'>
                    <Button>SIGN UP</Button>
                  </NavBtnLink>
                  
                ) : (
                  <NavBtnLink to='/sign-up'>
                    <Button onClick={closeMobileMenu}>
                      SIGN UP
                    </Button>
                  </NavBtnLink>
                )}
              </NavItemBtn>
              &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
              <NavItemBtn>
                {button ? (
                  <NavBtnLink to='/sign-in'>
                    <Button>SIGN IN</Button>
                  </NavBtnLink>
                ) : (
                  <NavBtnLink to='/sign-in'>
                    <Button onClick={closeMobileMenu}>
                      SIGN IN
                    </Button>
                  </NavBtnLink>
                )}
              </NavItemBtn>
            </NavMenu>
          </NavbarContainer>
        </Nav>
      </IconContext.Provider>
    </>
  );
}

export default Navbar;