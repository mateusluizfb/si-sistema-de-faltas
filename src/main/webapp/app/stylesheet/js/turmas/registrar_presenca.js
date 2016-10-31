
/**
 * Created by mateus on 27/10/16.
 */

function todos(cb){

    if(cb.checked){
        $("input[type='checkbox']").prop('checked', true);
    } else {
        $("input[type='checkbox']").prop('checked', false);
    }
}

(function () {

    document.querySelector(".input-data").onkeyup = function () {
        var mask = this.value;
        if (mask.match(/^\d{2}$/) !== null) {
            this.value = mask + '/';
        } else if (mask.match(/^\d{2}\/\d{2}$/) !== null) {
            this.value = mask + '/';
        }
    }

})();


