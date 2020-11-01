import {connect} from "react-redux";
import CreatePage from "../components/CreatePage";
import {addUser} from "../actions";

const mapDispatchToProps = (dispatch) =>({
    addUser: (todo) => {dispatch(addUser(todo))}
})

const CreatePageContainer = connect(null, mapDispatchToProps) (CreatePage)

export default CreatePageContainer;