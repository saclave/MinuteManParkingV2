import {connect} from "react-redux";
import CreateUser from "../components/CreateUser";
import {addUser} from "../actions";

const mapDispatchToProps = (dispatch) =>({
    addUser: (accounts) => {dispatch(addUser(accounts))}
})

const CreateUserContainer = connect(null, mapDispatchToProps) (CreateUser)

export default CreateUserContainer;