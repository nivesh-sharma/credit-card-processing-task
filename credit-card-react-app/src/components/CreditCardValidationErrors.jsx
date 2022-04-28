import React from 'react';


const ValidationErrors = props => {
  return (
    <div className="validation-errors">
      {props.errors.customerName &&
        <div className="alert">
          Name field cannot contain numbers or be empty.
        </div>
      }
      {props.errors.cardNumber &&
        <div className="alert">
        Card Number should be numeric, should not be more than 19 digits and should follow Luhn 10 algorithm.
        </div>
      }
      {props.errors.cardLimit &&
        <div className="alert">
          Limit field must be a valid number and greater than equal to 0.
        </div>
      }
    </div>
  )
}

export default ValidationErrors;
