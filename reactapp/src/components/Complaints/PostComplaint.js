import { useState } from "react";
import ComplaintService from "../../Services/ComplaintService";

function PostComplaintForm(props) {
    const [data,setData] = useState({
       // sender: "",
        title: "",
        description: ""
    })
function handle(e){
        const newData={...data}
        newData[e.target.id] = e.target.value;
        setData(newData);
        console.log(e.data);
}
    return(
        <div className = "container">
            <form>
                <label className ="sender" for="sender">Sender:</label>
                <input onChange={(e) => handle(e)} id="title"  value ={data.title} placeholder  = "Title" type ="text"></input>
                <label className ="description" for="description">Description</label>
                <input onChange={(e) => handle(e)} id="description"  value ={data.description}  placeholder = "Description" type ="text" ></input>

            </form>
        </div>
    )
}

export default PostComplaintForm;