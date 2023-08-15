(function blockScope() {

    // console.log(x); // error!
    let x = 5; console.log(x); // 5
    for (let x = 20; x < 30; x++)
        console.log(x) // 20 … 29
    console.log(x) // 5
    x = 10; console.log(x) // 10
    // let x = 5; // error!
}) ()
