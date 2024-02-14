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
        if(validationForm()){
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
    }

    console.log("inside todo component");

    const [errors, setErrors] = useState({

        title: "",
        description: "",
        isComplete: ""
    
      });
    
      const validationForm = () => {
        let valid = true;
        const errorsCopy = { ...errors };
    
        if(title?.trim()){
          errorsCopy.title = '';
    
        }
        else{
          errorsCopy.title = 'Title is required';
          valid = false;
        }
        if(description?.trim()){
          errorsCopy.description = '';
        }
        else{
          errorsCopy.description = "Description is required";
          valid = false;
        }
        if (isComplete?.trim()) {
          errorsCopy.isComplete = '';
        }
        else{
          errorsCopy.isComplete = "isComplete is required";
          valid = false;
        }
        
        setErrors(errorsCopy);
        return valid;
      }
    
    return(

        <Container>


        <Form.Label >Todo Title</Form.Label>
              <Form.Control
                type="text"
                value={title}
                onChange={(e)=>setTitle(e.target.value)}
              />
        {errors.title && <div style={{color:"red"}}>{errors.title}</div>}
        <Form.Label >Todo Description</Form.Label>
              <Form.Control
                type="text"
                value={description}
                onChange={e=>setDescription(e.target.value)}
              />
              {errors.description && <div style={{color:"red"}}>{errors.description}</div>}
<Form.Label >Todo Completed</Form.Label><br></br>
              

<Form.Select aria-label="Default select example" onChange={(e) => setIsComplete(e.target.value)}>

     
          
          <option>Open this select menu</option>
      <option value="Yes">Yes</option>
      <option value="No">No</option>
    </Form.Select>
    {errors.isComplete && <div style={{color:"red"}}>{errors.isComplete}</div>}


               
           <Button variant="primary" onClick={(e)=>saveOrUpdate(e)}>Submit</Button>{' '}
            </Container>
        
    )
}
export default ToDo;