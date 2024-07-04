function newAccount (initialBalance)
	local self = {balance = initialBalance, LIM = 10000.00,}

	local withdraw = function (v)
						 print(self)
						 self.balance = self.balance - v -- 使用的永远都是local self
				     end
	
	local deposit = function (v)
					    self.balance = self.balance + v
					end
	
	local extra = function ()
		if self.balance > self.LIM then
			return self.balance * 0.10
		else
			return 0
		end
	end

	local getBalance = function () 
		return self.balance + extra()
    end

	return {
		withdraw = withdraw,
		deposit = deposit,
		getBalance = getBalance
	}
end

