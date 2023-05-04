import React, {useState} from "react";

export default function Name() {
    const [name, setName] = useState("")
    const showName = (nameChange) => {
        setName(nameChange)
    }
    return (
        <>
            <input placeholder="name" value={name} onChange={(e) => showName(e.target.value)}/>
        </>
    )
}