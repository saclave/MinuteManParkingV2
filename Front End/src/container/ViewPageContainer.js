import { connect } from 'react-redux';
import { getAccount } from '../actions';
import ViewPage from '../components/ViewPage';

const mapDispatchToProps = dispatch => ({
    getAccount: (accounts) => { dispatch(getAccount(accounts)) },
});
const ViewPageContainer = connect(null, mapDispatchToProps)(ViewPage);

export default ViewPageContainer;