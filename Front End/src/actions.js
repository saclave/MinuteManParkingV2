export const addUser = (parking) => {
    return {type: "ADD_USER", payload: parking}
}

export const getAccount = accounts => {
    return { type: "GET_ACCOUNT", payload: accounts };
}
