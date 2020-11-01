<<<<<<< HEAD
=======
export const addUser = (parking) => {
    return {type: "ADD_ACCOUNT", payload: parking}
}

>>>>>>> 6aff67982ef90c6884907d5ca79e6bc7293924e1
export const getAccount = accounts => {
    return { type: "GET_ACCOUNT", payload: accounts };
}

export const addUser = accounts => {
    return {type: "ADD_ACCOUNT", payload: accounts}
}

export const updateUser = accounts => {
    return {type: "UPDATE_ACCOUNT", payload: accounts}
}
