import './App.css';
import React, {useState, useEffect} from "react";
import TodoForm from "./components/TodoForm";
import Todo from "./components/Todo";

function App() {

    const [data, setData] = useState([])
    const [isPending, setIsPending] = useState(true)
    const [error, setError] = useState()

    const onNewTodoHandler = (todo) => {
        const newData = [...data];
        newData.push(todo);
        setData(newData)
    }
    useEffect(()=> {
        setTimeout(()=> {
                fetch(`http://localhost:3001/todos`)
                    .then(response => {
                        if(response.ok){
                            return response.json()
                        }
                        throw new Error(`Unable to get data: ${response.statusText}`)
                    })
                    .then(json => setData(json))
                    .catch((err) => setError(err.message))
                    .finally(()=> setIsPending(false))
            }
            , 1000)
    },[])

    const onDelete = (id) => {
        console.log(id + " Clicked")
        fetch(`http://localhost:3001/todos/${id}`, {
            method: 'DELETE', //GET, POST, PUT, DELETE etc.
        }).then(response=> {
            if(response.ok){
                setData(data.filter((item) => {
                    return item.id !== id;
                }))
            }else {
                throw new Error(`Error: ${response.statusText}`)
            }
        }).catch((err) => setError(err.message))
    }

    return (
        <div className="App">
            <header className="App-header">
                <h2>Todo list</h2>
                <hr style={{ color: "white", width: "80%" }}/>
                <TodoForm onNewTodo={onNewTodoHandler}/>
                <hr style={{ color: "white", width: "80%" }}/>
                {isPending && "Loading data..."}
                {error && <div>{error}</div>}

                <div style={{
                    display: "flex",
                    flexDirection: "column",
                    flexWrap: "wrap",
                    margin: "5px"
                }}>
                    {data.map(item =>
                        <Todo
                            key={item.id}
                            todo={item}
                            onDelete={onDelete}
                        />
                    )}
                </div>
            </header>
        </div>
    );
}

export default App;
