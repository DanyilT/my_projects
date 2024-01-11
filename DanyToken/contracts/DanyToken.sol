// SPDX-License-Identifier: MIT
pragma solidity ^0.8.0;

import "@openzeppelin/contracts/token/ERC20/ERC20.sol";

contract DanyToken is ERC20 {
    uint256 public constant MAX_SUPPLY = 8e9 * 1e18;
    uint256 public constant MAX_MINT_PER_ADDRESS = 8e6 * 1e18;

    mapping(address => uint256) public mintedAmounts;

    constructor() ERC20("DanyToken", "DT") {
        _mint(msg.sender, 1e9 * 1e18);
    }

    function mint(uint256 value) public {
        require(value > 0, "DanyToken: mint value must be greater than zero");
        uint256 alreadyMinted = mintedAmounts[msg.sender];
        require(alreadyMinted + value <= MAX_MINT_PER_ADDRESS, "DanyToken: max mint limit exceeded per address");
        require(totalSupply() + value <= MAX_SUPPLY, "DanyToken: max total supply exceeded");

        mintedAmounts[msg.sender] += value;
        _mint(msg.sender, value);
    }

    function burn(uint256 value) public {
        _burn(msg.sender, value);
    }
}
