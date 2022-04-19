import React, {useState} from "react";

function TodoForm(props){
    const [taskTodo, setTaskTodo] = useState("")
    const [feedback, setFeedback] = useState()

    const onSubmitHandler = event => {
        event.preventDefault();
        const newTodo = {
            task: taskTodo
        }
        //if(newTodo.task.trim()){
            fetch(`http://localhost:3001/todos`, {
                method: 'POST', //GET, POST, PUT, DELETE etc.
                headers: {
                    'Content-Type': 'application/json'
                },
                body: JSON.stringify(newTodo) //body data type must match "Content-Type" header
            }).then(response=> {
                if(response.ok){
                    setFeedback(`Response: ${response.statusText}`)
                }else {
                    throw new Error(`Error: ${response.statusText}`)
                }
            }).catch((error) => setFeedback(error.message))
                .finally(()=> {
                    props.onNewTodo(newTodo);
                    setTaskTodo("");
                });
        //}
    }

    return(
        <>
            <form onSubmit={onSubmitHandler}>
                <input type="text" value={taskTodo} placeholder={"New Task"}
                       onChange={(e) => setTaskTodo(e.target.value)}/>
                <input type="submit" value={"Add"}/>
            </form>
            {feedback && <div>{feedback}</div>}
        </>
    );
}
export default TodoForm;