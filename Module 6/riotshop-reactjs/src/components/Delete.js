import Swal from "sweetalert2";
import React from "react";
import * as ProductService from "../service/ProductService";

export default function DeleteEmployee(props) {
  const token = localStorage.getItem("token");


  return (
    <>
      <div
        className="modal fade"
        id="deleteEmployee"
        tabIndex={-1}
        aria-labelledby="exampleModalLabel"
        aria-hidden="true"
      >
        <div className="modal-dialog">
          <div className="modal-content">
            <div className="modal-header">
              <h5 className="modal-title" id="exampleModalLabel">
                Xóa sản phẩm
              </h5>
              <button
                type="button"
                className="btn-close"
                data-bs-dismiss="modal"
                aria-label="Close"
              />
            </div>
            <div className="modal-body">
              Bạn có chắc chắn muốn xóa sản phẩm{" "}
              <span className="text-danger fw-bold">{props.name}</span> không?
            </div>
            <div className="modal-footer">
              <button
                type="button"
                className="btn btn-secondary"
                data-bs-dismiss="modal"
              >
                Hủy
              </button>
              <button
                onClick={() => handleDelete(props.id)}
                type="button"
                className="btn btn-primary"
                data-bs-dismiss="modal"
              >
                Xóa
              </button>
            </div>
          </div>
        </div>
      </div>
    </>
    // <>
    //     <div
    //         className="modal"
    //         id="deleteEmployee"
    //         tabindex={-1}
    //         aria-labelledby="exampleModalLabel"
    //         aria-hidden="true"
    //     >
    //         <div className="row mx-0">
    //             <div className="col-3"></div>
    //         <div className="modal-dialog col-9 w-100 mt-5 pt-5">
    //             <div className="modal-content">
    //                 <div className="modal-header">
    //                     <h1 className="modal-title fs-5" id="exampleModalLabel">
    //                         Xóa Nhân Viên
    //                     </h1>
    //                     <button
    //                         type="button"
    //                         className="btn-close"
    //                         data-bs-dismiss="modal"
    //                         aria-label="Close"
    //                     />
    //                 </div>
    //                 <div className="modal-body">
    //                     Bạn có chắc chắn muốn xóa nhân viên <span
    //                     className="text-danger fw-bold">{props.name}
    //                 </span> không?
    //                 </div>
    //                 <div className="modal-footer">
    //                     <button
    //                         type="button"
    //                         className="btn btn-secondary"
    //                         data-bs-dismiss="modal"
    //                     >
    //                         Hủy
    //                     </button>
    //                     <button onClick={() => handleDelete(props.id)} type="button" className="btn btn-danger"
    //                             data-bs-dismiss="modal">
    //                         Xóa
    //                     </button>
    //                 </div>
    //             </div>
    //         </div>
    //         </div>

    //     </div>
    // </>
  );
}
