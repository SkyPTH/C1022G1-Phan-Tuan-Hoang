import {ErrorMessage, Field, Form, Formik} from 'formik'
import 'react-toastify/dist/ReactToastify.css';
import * as Yup from 'yup'
import {toast, ToastContainer} from 'react-toastify'
import {RotatingLines} from "react-loader-spinner";

export default function MedicalForm() {
    return (<>
        <Formik initialValues={{
            name: '', birth: ',', gender: '', isHaveHealthCard: false, contactWith: []
        }}
                validationSchema={Yup.object({
                    name: Yup.string().required('Không đc bỏ trống'),
                    birth: Yup.number().required('Không đc bỏ trống'),
                    gender: Yup.string().required('Không đc bỏ trống'),
                    isHaveHealthCard: Yup.boolean().required('Không đc bỏ trống')
                })}
                onSubmit={(values, {setSubmitting}) => {
                    setTimeout(() => {
                        setSubmitting(false);
                        toast("Thành công");
                    }, 500)
                }}
        >
            {({isSubmitting}) => (
                <Form>
                    <div className='row px-0'>
                        <div>
                            <h2>Khai báo y tế</h2>
                            <div>
                                <Field type='text' name='name' placeholder='Nhập tên'/>
                                <ErrorMessage name='name' component={'div'} className='text-danger'/>
                            </div>
                            <div>
                                <Field type='number' name='birth' placeholder='Nhập tuổi'/>
                                <ErrorMessage name='name' component={'div'} className='text-danger'/>
                            </div>
                            <div>
                                <span>Giới tính</span>
                                <div className="form-check form-check-inline">
                                    <Field
                                        className="form-check-input"
                                        type="radio"
                                        name="gender"
                                        id="gender-1"
                                        value="1"
                                    />
                                    <label htmlFor='gender-1' className='form-check-label'>Nam</label>
                                    <Field
                                        className="form-check-input"
                                        type="radio"
                                        name="gender"
                                        id="gender-2"
                                        value="2"
                                    />
                                    <label htmlFor='gender-2' className='form-check-label'>Nữ</label>
                                </div>
                                <ErrorMessage name='gender' component={'div'} className='text-danger'/>
                            </div>
                            <div>
                                <span htmlFor='isHaveHealthCard'>Có thẻ bảo hiểm y tế</span>
                                <Field
                                    className='form-check-input'
                                    type='checkbox'
                                    name='isHaveHealthCard'
                                    id='isHaveHealthCard'
                                />
                                <ErrorMessage name='isHaveHealthCard' component={'div'} className='text-danger'/>
                            </div>
                            {
                                isSubmitting ?
                                    <RotatingLines
                                        strokeColor='grey'
                                        strokeWidth='5'
                                        width='50'
                                        visible={true}
                                        animationDuration='0.75'
                                    /> : <button type='submit' className='btn btn-primary'>Xác nhận</button>
                            }
                        </div>
                    </div>
                    <ToastContainer/>
                </Form>)}
        </Formik>
    </>)
}