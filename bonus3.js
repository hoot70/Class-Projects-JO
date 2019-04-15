// Examples:
// argh("abcd") -> "A-Bb-Ccc-Dddd"
// argh("RqaEzty") -> "R-Qq-Aaa-Eeee-Zzzzz-Tttttt-Yyyyyyy"
// argh("cwAt") -> "C-Ww-Aaa-Tttt"
// The parameter of argh is a string which includes only letters from a..z and A..Z



function argh(s) {
    array = []
    for(i = 0; i < s.length; i++){
        word = s.charAt(i);
        sup = word.toUpperCase();
        sup += word.repeat(i).toLowerCase();
        array.push(sup);
    }
    return array.join('-');
     
}

console.log(argh("cwAt"));
