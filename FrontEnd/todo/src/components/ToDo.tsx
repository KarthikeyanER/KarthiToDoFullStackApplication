import { FormEvent, useEffect, useState } from "react";
import { Container, Form, Button } from "react-bootstrap";
import { useHistory, useParams } from "react-router-dom";
import { createToDo, editToDoById, getToDoById } from "../services/ToDoService";
type RouteParams={
    id:string;
}
type ToDo={
    id:number;
    title:string;
    description:string;
    isComplete:string
}
type Complete={
value:string;
}
const ToDo:React.FC=()=>{
    const [title,setTitle]=useState<string>("");
    const [description,setDescription]=useState<string>("");
    const [isComplete,setIsComplete]=useState<string>("");
    const [completeArray,setCompleteArray]=useState<Complete[]>([{value:"No"},{value:"Yes"}]);
    
    

    const {id}=useParams<RouteParams>();
    useEffect(()=>{

        if(id){
            getToDoById(Number(id))
            .then((response)=>{
               
                setTitle(response.data.title);
                setDescription(response.data.description);
                setIsComplete(response.data.isComplete);
            
            })
            .catch(error=>console.log(error));
        }
    },[id]);

    const history=useHistory();
    const saveOrUpdate=(e:FormEvent)=>{

        e.preventDefault();
        if(id){
        const todo={title,description,isComplete};
        editToDoById(Number(id),todo)
        .then((response)=>history.push("/todo"))
        .catch(error=>console.log(error));
        }
        else{
            const todo={title,description,isComplete};
            createToDo(todo)
            .then((response)=>history.push("/todo"))
            .catch(error=>console.log(error));
            }
    }

    console.log("inside todo component");
    return(

        <Container>


        <Form.Label >Todo Title</Form.Label>
              <Form.Control
                type="text"
                value={title}
                onChange={(e)=>setTitle(e.target.value)}
              />
        
        <Form.Label >Todo Description</Form.Label>
              <Form.Control
                type="text"
                value={description}
                onChange={e=>setDescription(e.target.value)}
              />
<Form.Label >Todo Completed</Form.Label><br></br>
              

<Form.Select aria-label="Default select example" onChange={(e) => setIsComplete(e.target.value)}>

     
          
          <option>Open this select menu</option>
      <option value="Yes">Yes</option>
      <option value="No">No</option>
    </Form.Select>


               
           <Button variant="primary" onClick={(e)=>saveOrUpdate(e)}>Submit</Button>{' '}
            </Container>
        
    )
}
export default ToDo;