import styled from 'styled-components';
import { Link } from 'react-router-dom';
import { Container } from '../../globalStyles';

export const Nav = styled.nav`
  background: #101522;
  height: 80px;
  display: flex;
  justify-content: center;
  align-items: center;
  font-size: 1.2rem;
  position: sticky;
  top: 0;
  z-index: 999;
`;

export const NavbarContainer = styled(Container)`
  display: flex;
  justify-content: space-between;
  height: 80px;
  width: 100%;
`;

export const NavLogo = styled(Link)`
  color: #fff;
  justify-self: flex-start;
  cursor: pointer;
  margin-left: -20%;
  text-decoration: none;
  font-size: 2.5rem;
  display: flex;
  align-items: center;

  @media screen and (max-width: 960px) {
    margin-left: 0;
  }
  @media screen and (max-width: 1366px) {
    margin-left: 0;
  }
`;


export const MobileIcon = styled.div`
  display: none;
  @media screen and (max-width: 960px) {
    display: block;
    position: absolute;
    top: 0;
    right: 0;
    transform: translate(-100%, 60%);
    font-size: 1.8rem;
    cursor: pointer;
  }
`;

export const NavMenu = styled.ul`
  display: flex;
  align-items: center;
  list-style: none;
  text-align: center;
  @media screen and (max-width: 960px) {
    display: flex;
    flex-direction: column;
    width: 100%;
    height: 90vh;
    position: absolute;
    top: 80px;
    left: ${({ click }) => (click ? 0 : '-100%')}; //
    opacity: 1;
    transition: all 0.5s ease;
    background: #101522;
  }
`;

export const NavItem = styled.li`
  height: 80px;
  border-bottom: 2px solid transparent;
  &:hover {
    color: black;
  }
  @media screen and (max-width: 960px) {
    width: 100%;
    &:hover {
      border: none;
    }
  }
`;

export const NavItemBtn = styled.li`
  @media screen and (max-width: 960px) {
    display: flex;
    justify-content: center;
    align-items: center;
    width: 100%;
    height: 120px;
  }
`;

export const NavLinks = styled(Link)`
  color: #fff;
  display: flex;
  align-items: center;
  text-decoration: none;
  padding: 0.5rem 2rem;
  font-size: 1.7rem;

  height: 100%;
  @media screen and (max-width: 960px) {
    text-align: center;
    margin-left: 0;
    padding: 2rem;
    width: 100%;
    display: table;
    &:hover {
      color: #4b59f7;
      transition: all 0.3s ease;
    }
    @media screen and (max-width: 1366px) {
      text-align: center;
      margin-left: 0;
      padding: 2rem;
      width: 100%;
      display: table;
      &:hover {
        color: #4b59f7;
        transition: all 0.3s ease;
      }
    }
  }
`;

export const NavBtnLink = styled(Link)
`
  display: block;
  text-decoration: none;
  margin-left: 200%;
  height: 100%;
  width: 100%;
  border: none;
  outline: none;
  

  @media screen and (max-width: 960px) {
    padding: 8px 16px;
    margin-left: 0;
  }
`;