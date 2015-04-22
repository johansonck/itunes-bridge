tell application "iTunes"
	set allPlaylists to {}
	
	repeat with i from 1 to count of playlists
		tell playlist i
			try
				set end of allPlaylists to get persistent ID & tab & name & tab & special kind & tab & persistent ID of parent
			on error
				set end of allPlaylists to get persistent ID & tab & name & tab & special kind & tab
			end try
		end tell
	end repeat
	
	return allPlaylists
end tell