import React from 'react';
import '../node_modules/bootstrap/dist/css/bootstrap.min.css';
import './App.css';
import Navbar from './components//Navbar/NavBar';
import { BrowserRouter as Router, Switch, Route } from 'react-router-dom';
import News from './pages/news';
import Complaints from './pages/complaints';
import Schedule from './pages/schedule';
import Users from './pages/users';
import SignUp from './pages/signup';
import SignIn from './pages/signin';
import SignOut from './pages/signout';
import buyTicket from './pages/buyTicket';
import { Profile } from './components/Users/profile';
import NotFound from './components/PageNotFound';
import MovieList from './components/Movies/MovieList';
import UserTickets from './components/Users/UserTickets';
import EditMovie from './components/Movies/EditMovie';
import RoomsPage from './components/Rooms/RoomsPage';
import Chat from './pages/chat';
import QRCodeGenerator from './components/Ticket/QRCodeGenerator'
import ReactNotification from 'react-notifications-component'
import ProjectionPage from './components/Projections/ProjectionPage';

function App() {
 
  return (
    <div className="app-container">
    <ReactNotification />
    <Router>
      <Navbar />
      <Switch>
        <Route path='/' exact component={News} />
        <Route path='/news' exact component={News} />
        <Route path='/schedule' component={Schedule} />
        <Route path='/complaints' component={Complaints} />
        <Route path='/sign-up' component={SignUp} />
        <Route path='/sign-in' component={SignIn} />
        <Route path='/sign-out' component={SignOut} />
        <Route path='/buyTicket' component={buyTicket} />
        <Route path="/ticket" component={QRCodeGenerator}/>
        <Route path='/users' component={Users} />
        <Route path='/profile' component={Profile} />
        <Route path='/movie-list' component={MovieList} />
        <Route path='/myTickets' component={UserTickets} />
        <Route path='/received-complaints' component={Complaints} />
        <Route path='/rooms' component={RoomsPage} />
        <Route path='/editMovie/' component={EditMovie} />
        <Route path='/projections' component={ProjectionPage} />
        <Route path='/chat' component={Chat} />
        <Route component={NotFound} />
      </Switch>

      {/* <AuthVerify logOut={AuthService.logout()} /> */}
    </Router>
    </div>
    
    
  );
}

export default App;
