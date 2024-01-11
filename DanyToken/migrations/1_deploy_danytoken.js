const DanyToken = artifacts.require("DanyToken");

module.exports = function (deployer) {
    deployer.deploy(DanyToken);
};
