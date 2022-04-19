import React, {useState} from "react";

function Todo({todo, onDelete}){
    const onDeleteHandler = () => {
        onDelete(todo.id);
    }

    return(<div style={{
        display: "grid",
        gridTemplateColumns: "auto auto",
        padding: "10px",
        fontSize: "14px"
    }}>
        <div style={{ textAlign: "left", padding: "10px"}}>
            {todo.task}
        </div>
        <div style={{ textAlign: "right", padding: "10px"}}>
            <button onClick={onDeleteHandler}>Done</button>
        </div>
    </div>)
}
export default Todo;