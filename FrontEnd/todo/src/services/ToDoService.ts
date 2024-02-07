import axios from "axios";

const baseUrl="http://localhost:8080/api/todo";
export const getToDoById=(id:number)=>axios.get(baseUrl+"/"+id);
export const getAllToDo=()=>axios.get(baseUrl);
export const createToDo=(todo:any)=>axios.post(baseUrl,todo);
export const editToDoById=(id:number,todo:any)=>axios.put(baseUrl+"/"+id,todo);
export const deleteToDoById=(id:number)=>axios.delete(baseUrl+"/"+id);
export const completeToDoById=(id:number)=>axios.get(baseUrl+"/complete/"+id);
export const inCompleteToDoById=(id:number)=>axios.get(baseUrl+"/incomplete/"+id);
