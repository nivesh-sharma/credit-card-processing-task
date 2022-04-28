import React from 'react';


const Table = props => {
  return (
    <table className="table">
      <thead className="thead-dark">
        <tr>
          <th scope="col">Name</th>
          <th scope="col">Card Number</th>
          <th scope="col">Balance</th>
          <th scope="col">Limit</th>
        </tr>
      </thead>
      <tbody>
        {
          props.cards.map(card =>
            <tr key={card.cardNumber}>
              <td> {card.customerName} </td>
              <td> {formatNumber(card.cardNumber)} </td>
              <td> £0 </td>
              <td> {card.cardLimit} </td>
            </tr>
          )
        }
      </tbody>
    </table>
  );
}

const formatNumber = cardNumber => {
  return cardNumber.replace(/ /g,'')
               .replace(/-/g,'');
}

export default Table;
