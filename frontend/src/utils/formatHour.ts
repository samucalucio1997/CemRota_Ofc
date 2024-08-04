export function formatHour(hora: number){
    if(hora == 0) return `00:00`;
    if(hora >= 1 && hora <= 9) return `0${hora}:00`;
    if(hora >= 10) return `${hora}:00`
}