const TOKEN: string = 'token'
const REFRESH_TOKEN_KEY: string = 'REFRESH_TOKEN_KEY'

export const getToken = () => {
    const token = localStorage.getItem(TOKEN);
    /* if(!token){
        window.location.href = "/"
    } else {
        return token;
    } */
    return token;
}
export const setToken = (token: string) => localStorage.setItem(TOKEN, token)
export const removeToken = (): void => localStorage.removeItem(TOKEN)

export const setRefreshToken = (refresh_token: string) => localStorage.setItem(REFRESH_TOKEN_KEY, refresh_token)
export const getRefreshToken = () => localStorage.getItem(REFRESH_TOKEN_KEY)

interface serviceInt {
    [key: string]: string
}

export const SERVICE: serviceInt = {
    CORE: 'http://localhost:8080/'
}