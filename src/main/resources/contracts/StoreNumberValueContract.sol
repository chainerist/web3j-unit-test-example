// SPDX-License-Identifier: MIT
pragma solidity ^0.8.7;

    error ValueMustBeGraterThanZero();

contract StoreNumberValueContract {

    uint256 private value;

    // Emitted when the stored value changes
    event ValueChanged(uint256 newValue);

    // Stores a new value in the contract
    function store(uint256 newValue) public {
        if (newValue < 1) {
            revert ValueMustBeGraterThanZero();
        }
        value = newValue;
        emit ValueChanged(newValue);
    }

    function retrieve() public view returns (uint256) {
        return value;
    }
}