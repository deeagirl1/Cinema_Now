import React from 'react';
import '../node_modules/bootstrap/dist/css/bootstrap.min.css';
import './App.css';
import Navbar from './components//user..view/Navbar/NavBar';
import { BrowserRouter as Router, Switch, Route } from 'react-router-dom';
import News from './pages/news';
import Complaints from './pages/complaints';
import Schedule from './pages/schedule';
import Users from './pages/users';
import SignUp from './pages/signup';
import SignIn from './pages/signin';
import SignOut from './pages/signout';
import buyTicket from './pages/buyTicket';
import sentComplaints from './pages/received-complaints'
import NotFound from './components/PageNotFound';

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
        <Route path='/sign-out' component={SignOut} />
        <Route path='/buyTicket' component={buyTicket} />
        <Route path= '/users' component ={Users}/>
        <Route path='/received-complaints' component={sentComplaints} />
        <Route component={NotFound}/>
      </Switch>
      
    </Router>

    
    
  );
}

export default App;
