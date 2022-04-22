(function(window, document, undefined){
  window.onload = init;
  
  function init(){
    let dropdown = document.getElementById('countries-dropdown');
    dropdown.length = 0;

    let defaultOption = document.createElement('option');
    defaultOption.text = 'Select country';

    dropdown.add(defaultOption);

    const url = 'http://localhost:8080/countries';

    fetch(url)  
      .then(  
        function(response) {  
          if (response.status !== 200) {  
            console.warn('Looks like there was a problem. Status Code: ' + 
              response.status);  
            return;  
          }

          
          // Examine the text in the response  
          response.json().then(function(data) {  
            let option;

            for (let i in data) {
              option = document.createElement('option');
              option.text = data[i];
              option.value = i;

              dropdown.add(option);
            }    
          });  
        }  
      )  
    .catch(function(err) {  
      console.error('Fetch Error -', err);  
    });
  }
  
})(window, document, undefined);