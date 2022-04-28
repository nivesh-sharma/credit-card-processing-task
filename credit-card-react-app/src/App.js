import React, { useState, useEffect } from "react";
import $ from 'jquery-ajax';
import './App.css';
import Form from './components/CreditCardForm';
import CardList from './components/CreditCardList';
import ValidationErrors from './components/CreditCardValidationErrors';

const urlGetAll = "http://127.0.0.1:8080/api/v1/creditCards/getAll";
const urlAdd = "http://127.0.0.1:8080/api/v1/creditCards/add";


function App() {
  const [card, setCard] = useState({
          customerName: '', cardNumber: '', cardLimit: 0
  });
  const [validationErrors, setValidationErrors] = useState({
    customerName: false, cardNumber: false, cardLimit: false
  });
  const [cardList, setCardList] = useState([]);

  useEffect(() => {
    $.get(urlGetAll, response => setCardList(response));
  }, []);

  const handleInputChange = event => {
    let obj = {[event.target.name] : event.target.value};
    setCard(() => ({ ...card, ...obj }));
  }

  const isFormValid = () => {
    const customerNameRegex = /^[^0-9.]+$/;
    const numericRegex = /^[0-9]+$/;
    let errors = {customerName: true, cardNumber: true, cardLimit: true};
    if (customerNameRegex.test(card.customerName))
      errors.customerName = false;
    if (checkCardNumber() && numericRegex.test(card.cardNumber))
      errors.cardNumber = false;
    if (numericRegex.test(card.cardLimit) && card.cardLimit >= 0)
      errors.cardLimit = false;
    setValidationErrors(errors);
    return !Object.values(errors).some(error => error === true);
  }

  const checkCardNumber = () => {
    const cardNumber = card.cardNumber.replace(/ /g,'').replace(/-/g,'');
    return cardNumber.length <= 19 ;
  }  


  const addCard = () => {
    if (isFormValid()){
      $.ajax({
        url:urlAdd,
        type:"POST",
        data:JSON.stringify(card),
        contentType:"application/json;charset=utf-8",
        success: function(r){
          setCardList( [...cardList, card] );
          setCard({customerName: '', cardNumber: '', cardLimit: ''});
        },
        error: function(xhr, status, error){
          if (xhr.status === 409) {
            alert("A Credit Card with that Number already exists!");
          } else if (xhr.status === 403) {
            alert("Credit card number is not valid as per Luhn 10 Algorithm");
          } else  {
            alert("A service error occurred, please try again later!");
          } 
        }
      });
    }
  }

  return (
    <div className="App">
      <h1>Credit Card System</h1>
      <h3> Add </h3>

      <Form card={card} 
            handleInputChange={handleInputChange}
            addCard={addCard} />

      <ValidationErrors errors={validationErrors} />

      <CardList cards={cardList} />

    </div>
  );
}

export default App;
