import React from 'react';
import '../node_modules/bootstrap/dist/css/bootstrap.min.css';
import './App.css';
import Navbar from './components/Navbar';
import { BrowserRouter as Router, Switch, Route } from 'react-router-dom';
import News from './pages/news';
import Complaints from './pages/complaints';
import Schedule from './pages/schedule';
import SignUp from './pages/signup';
import SignIn from './pages/signin';
import UserTest from './pages/APIUserTest'


function App() {
 
  
  return (
    <Router>
      <Navbar/>
      <Switch>
        <Route path='/' exact component={News} />
        <Route path='/news' exact component={News} />
        <Route path='/schedule' component={Schedule} />
        <Route path='/complaints' component={Complaints} />
        <Route path='/sign-up' component={SignUp} />
        <Route path='/sign-in' component={SignIn} />
        <Route path='/api_user_test' component={UserTest}/>
      </Switch>
    </Router>

    
  );
}

export default App;
