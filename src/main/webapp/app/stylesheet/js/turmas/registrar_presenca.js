
/**
 * Created by mateus on 27/10/16.
 */

$ = document.querySelector;
function todos(cb){
    if(cb.checked == true){
        document.querySelector("input").checked = true;
    } else {
        document.querySelector("input").checked = false;
    }
}

