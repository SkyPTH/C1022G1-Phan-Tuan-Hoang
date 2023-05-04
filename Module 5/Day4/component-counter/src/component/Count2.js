import {useState} from "react"

export default function Count2() {
    const [count2, setCount2] = useState(2)
    const add1 = () => {
        setCount2(prevState => prevState + 2)
    }
    return (
        <>
            <h2>{count2}</h2>
            <div>
                <button onClick={add1}> Add 2</button>
            </div>
        </>
    )
}