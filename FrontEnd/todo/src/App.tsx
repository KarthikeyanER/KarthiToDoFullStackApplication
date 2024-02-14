import React from 'react';

import { Route, Switch } from 'react-router-dom';
import ListToDo from './components/ListToDo';
import ToDo from './components/ToDo';



function App() {
  return (
    <>
   <Switch>
    <Route path="/" exact><ListToDo></ListToDo></Route>
    <Route path="/edit-todo/:id"><ToDo></ToDo></Route>
    <Route path="/todo"><ListToDo/></Route>
    <Route path="/add-todo"><ToDo></ToDo></Route>
    
   </Switch>
    </>
  );
}

export default App;
