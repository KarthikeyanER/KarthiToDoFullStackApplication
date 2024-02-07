import { useEffect, useState } from "react";
import { Container, Table, Button } from "react-bootstrap";
import { Link, useHistory } from "react-router-dom";
import { completeToDoById, deleteToDoById, editToDoById, getAllToDo, getToDoById, inCompleteToDoById } from "../services/ToDoService";
type ToDo={
    id:number;
    title:string;
    description:string;
    isComplete:string
}
const ListToDo:React.FC=()=>{

    const [listToDo,setListToDo]=useState<ToDo[]>([]);




    const ListOFTodos=()=>{
        getAllToDo()
        .then((response)=>{
            console.log("inside getAll before set");
            setListToDo(response.data);
            console.log("inside getAll after set");
          
        })
        .catch(error=>console.log(error));
    }
    useEffect(()=>{
        
        ListOFTodos();
        
    },[]);

    const history=useHistory();

    const updateToDo=(id:number)=>{

        history.push(`/edit-todo/${id}`);
    }
    
    const deleteToDo=(id:number)=>{
        deleteToDoById(id)
        .then((respsonse)=>{
            ListOFTodos();
        })
        .catch(error=>console.log(error));
    }

    
    const completeToDo=(id:number)=>{
completeToDoById(id)
.then(()=>{
ListOFTodos();
});
    }
const inCompleteToDo=(id:number)=>{
    inCompleteToDoById(id)
    .then(()=>{
    ListOFTodos();
    })

    };
    
    
    return(
       
        <Container> 
        <h1 style={{textAlign:"center"}}>List of Todos</h1>
        <Link to="/add-todo" className="btn btn-primary mb-2">Add ToDo</Link>
        <Table striped bordered hover variant="dark">
     <thead>
       <tr>
         <th>Todo Title</th>
         <th>Todo Description</th>
         <th>Todo Completed</th>
         <th>Actions</th>
        
       </tr>
      
     </thead>
     <tbody>
{listToDo.map((todo)=>


<tr key={todo.id}>
<td>{todo.title}</td>
<td>{todo.description}</td>
<td>{todo.isComplete}</td>

<td>
<Button variant="primary" onClick={()=>updateToDo(todo.id)}>Update</Button>{' '}
<Button variant="danger" onClick={()=>{deleteToDo(todo.id)}}>Delete</Button>{' '}
<Button variant="success" onClick={()=>completeToDo(todo.id)}>Complete</Button>{' '}
<Button variant="primary" onClick={()=>{inCompleteToDo(todo.id)}}>InComplete</Button>{' '}
</td>



</tr>
)}
     
           
       
       
       
     </tbody>
   </Table>
   </Container>
    )
}
export default ListToDo;