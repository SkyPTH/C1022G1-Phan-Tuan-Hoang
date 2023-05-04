import {useState} from "react"

export default function Count() {
    const [count, setCount] = useState(1)
    const add1 = () => {
        setCount(prevState => prevState + 1)
    }
    return (
        <>
            <h2>{count}</h2>
            <div>
                <button onClick={add1}> Add 1</button>
            </div>
        </>
    )
}