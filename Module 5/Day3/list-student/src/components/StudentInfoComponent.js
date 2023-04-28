import { Component } from "react";
export class StudentInfoComponent extends Component{
    constructor() {
        super();
        this.state = {
            studentList: [
                {
                    id: 1,
                    studentName: "Phan Tuấn Hoàng",
                    age: 18,
                    address: "Đà Nẵng"
                },
                {
                    id: 2,
                    studentName: "Hoàng Đẹp Trai",
                    age: 20,
                    address: "Đà Nẵng"
                },
                {
                    id: 3,
                    studentName: "Nguyễn Thị Loan",
                    age: 18,
                    address: "Quảng Nam"
                }
            ]
        }
    }
    render(){
        return(
            <div>
                <h2>Danh sách sinh viên</h2>
                <table>
                    <thead>
                    <tr>
                        <th>Id</th>
                        <th>Name</th>
                        <th>Age</th>
                        <th>Address</th>
                    </tr>
                    </thead>
                    <tbody>
                    {
                        this.state.studentList.map((student,index)=>(
                            <tr key={index}>
                                <td>{student.id}</td>
                                <td>{student.studentName}</td>
                                <td>{student.age}</td>
                                <td>{student.address}</td>
                            </tr>
                        ))
                    }
                    </tbody>
                </table>
            </div>
        )
    }
}