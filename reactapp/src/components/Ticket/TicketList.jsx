import React from "react";
import TicketItem from "./TicketItem";
function TicketList(props){

    const handleDelete = (id) =>{
        props.onDelete(id);
    };

return(
    <ul>
        {props.tickets.map((ticket)=>(
            <UserItem key = {ticket.holder_id} user = {user} onDelete = {handleDelete}></UserItem>
        ))}
    </ul>
    )

}

export default TicketList;