import React, {Component} from "react";
import {MenuItems} from "./MenuItems";
import './Navbar.css'
import {Button} from "../Button.js";
class Navbar extends Component{
   state = {clicked: false}
    handledClick = () => {
        this.setState({clicked: !this.state.clicked})
    }

   
    render(){
        return(
            <nav className = "NavbarItems">
                <h1 className="navbar-logo">Cinema_Now</h1>
                <div className="menu-icon" onClick={this.handledClick}>
                    <i className={this.state.clicked ? 'fas fa-times' : 'fas fa-bars'}></i>
                </div>

                    <ul className={this.state.clicked ? 'nav-menu active':
                'nav-menu'}>
                        {MenuItems.map((item,index) =>{
                            return(
                              <li key={index}>
                                  <a className={item.cName} href={item.url}>
                                   {item.title}
                                 </a>
                             </li>
                            )
                        })}
                        
                    </ul>
                    <Button>Sign Up</Button>
                    <Button>Sign In</Button>
            </nav>
        )
    }
}

export default Navbar