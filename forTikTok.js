import React, { useState } from 'react';

const forTikTok = () => {
  const [first, setfirst] = useState(0);

  const incFunct = () => {
    setfirst(first++);
  };

  console.log(first);

  return <div>forTikTok</div>;
};

export default forTikTok;
