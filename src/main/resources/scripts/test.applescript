tell application "iTunes"
	tell (some playlist whose persistent ID is "FB6503A189F7B7C3")
		get name of file tracks whose name starts with "Take"
	end tell
end tell