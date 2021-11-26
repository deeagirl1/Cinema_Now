function UserListComponent(){
    const [user,setUser] = useState([]);

    useEffect(() => {
        getUser()
    }, [])

    const getUser = () => {
        UserService.getUser().then((response) => {
            setUser(response.data);
            console.log(response.data);
        });
    }

    return(
        <div>
        <div  class = "complaint-item-container">
       {user.map(
           user => 
         <div key={user.id}>
           <div className="firstName">{user.firstName}</div>
           <br/>
           <div className="lastName">{user.lastName}</div>
           <br/>
           <div className="email">{user.email}</div>
           <div className="age">{user.age}</div>
           </div>
       )}
        </div>
     </div>
    )
}