export const getAccount = accounts => {
    return { type: "GET_ACCOUNT", payload: accounts };
}

export const addUser = accounts => {
    return {type: "ADD_ACCOUNT", payload: accounts}
}

export const updateUser = account => {
    return {type: "UPDATE_ACCOUNT", payload: account}
}
